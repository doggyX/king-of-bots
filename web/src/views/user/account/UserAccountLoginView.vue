<template>
    <ContentField v-if="show_content">
        <div class="row justify-content-md-center">
            <div class="col-3">
                <form @submit.prevent="login">  
                    <!-- 提交了就触发函数 .prevent 是阻止默认行为 -->
                        <div class="mb-3">
                            <label for="username" class="form-label">用户名</label>
                            <input v-model="username" type="text" class="form-control" id="username" placeholder="请输入用户名">
                            </div> 
                         <div class="mb-3">
                            <label for="password" class="form-label">密码</label>
                            <input v-model="password" type="password" class="form-control" id="password" placeholder="请输入密码">
                            </div>
                            <div class="error-message">{{ error_message }}</div>
                        <button type="submit" class="btn btn-primary">提交</button>
                </form>
            </div>
        </div>
    </ContentField>
</template>

<script>
import ContentField from "../../../components/ContentField.vue"
import { useStore } from 'vuex'
import { ref } from 'vue'
import router from "@/router"
export default {
    components: {
        ContentField
    },
    setup() {
        const store = useStore();
        let username = ref('');
        let password = ref('');
        let error_message = ref('');
        let show_content = ref(false);

        const jwt_token = localStorage.getItem("jwt_token");
        if (jwt_token) {
            store.commit("updateToken", jwt_token);
            store.dispatch("getinfo", {
                success() {
                    router.push({ name: "home" });
                },
                error() {
                    show_content.value = true;
                }
            }) 
        } else {
            show_content.value = true;
        }
        const login = () => {
            error_message.value = "";
            // 想调用action里的函数用dispatch
            store.dispatch("login", {
                username: username.value,
                password: password.value,
                success() {
                    store.dispatch("getinfo", {
                        success() {
                            router.push({ name: 'home' }); // 成功了就跳转页面
                           // console.log(store.state.user);
                        }
                    })
                    router.push({ name: 'home' }); // 成功了就跳转页面
                },
                error() {
                    error_message.value = "用户名或密码错误";
                }
            })
        }

        return {
            username,
            password,
            error_message,
            login,
            show_content
        }
    }
}
</script>

<style scoped>
button {
    width: 100%;
}

div.error-message {
    color: red;
}
</style>