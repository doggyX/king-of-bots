<template>
 <div>
  <div>Bot 昵称：{{ bot_name }}</div>
  <div>Bot 战力：{{ bot_rating }}</div>

 </div>
  <router-view/>
</template>

<script>
import $ from 'jquery'; 
import { ref } from 'vue';

export default {  //  相当于创建了一个vue实例-同学说的
  name: "App",
  setup: () => { // 整个函数的入口
    let bot_name = ref("");
    let bot_rating = ref("");

    $.ajax({
      url: "http://127.0.0.1:3000/pk/getBotInfo/",
      type: "get",
      success: resp => {
        //console.log(resp); // resp这一波就拿到了getBotInfo的内容
        bot_name.value = resp.name;
        bot_rating.value = resp.rating;
      }
    })

    return {
      bot_name,
      bot_rating
    }
  }
}
</script>

<style>
body {
  background-image: url("@/assets/background.png");  
  background-size: cover; 
  /* 百分百填充 */
  /* @/ 表示根目录 */
}
</style>
