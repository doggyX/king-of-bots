<template>
    <ContentField>
        我的bot
    </ContentField>
</template>

<script>
import ContentField from "../../../components/ContentField.vue"
import $ from 'jquery';
import { useStore } from "vuex";

export default {
    components: {
        ContentField
    },
    setup() {
        const store = useStore();
        // $.ajax({
        //      url: "http://localhost:3000/user/bot/add/",
        //     type: "post",
        //     data: {
        //         title: "Bot标题",
        //         description: "描述",
        //         content: "代码",

        //     },
        //     headers: {
        //         Authorization: "Bearer " + store.state.user.token
        //     },
        //     success(resp) {
        //         console.log(resp);
        //     },
        //     error(resp) {
        //         console.log(resp);
        //     }
        // })

        // $.ajax({
        //     url: "http://localhost:3000/user/bot/remove/",
        //     type: "post",
        //     data: {
        //         bot_id: 12

        //     },
        //     headers: {
        //         Authorization: "Bearer " + store.state.user.token,
        //     },
        //     success(resp) {
        //         console.log(resp);
        //     },
        //     error(resp) {
        //         console.log(resp);
        //     }
        // });

        //  $.ajax({
        //     url: "http://localhost:3000/user/bot/update/",
        //     type: "post",
        //      data: {
        //         bot_id:1,
        //         title: "Bot标题5",
        //         description: "描述5",
        //         content: "代码5",

        //     },
        //     headers: {
        //         Authorization: "Bearer " + store.state.user.token
        //     },
        //     success(resp) {
        //         console.log(resp);
        //     },
        //     error(resp) {
        //         console.log(resp);
        //     }
        // })

        $.ajax({
            url: "http://localhost:3000/user/bot/getlist/",
            type: "get",
            // data: {
            //     bot_id: 1,
            //     title: "Bot标题5",
            //     description: "描述5",
            //     content: "代码5",

            // },
            headers: {
                Authorization: "Bearer " + store.state.user.token
            },
            success(resp) {
                console.log(resp);
            },
            error(resp) {
                console.log(resp);
            }
        })

        
    }
}
</script>

<style scoped></style>