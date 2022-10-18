<template>
  <div>
    <!-- <button @click="test">点我</button> -->
    <button @click="test2">点我1111</button>
    <div v-for='(item, index) in result3'>
      <p>{{item.createTime}}</p>
      <p>{{item.garde}}</p>
    </div>
  </div>
</template>

<script>
  import {test} from '@/api'
  export default {
    data() {
      return {
        results:[],
        result1:[],
        result2:[],
        result3:[],
        result4:[],
        result5:[],
      }
    },
    methods: {
      test() {
        test().then(
          response =>{
            this.results = response.data.data;
            // this.results = JSON.parse(response.data.data);
            console.log(this.results);
            console.log(typeof(this.results));
          }
        )
      },
      test2(){
        this.result3 = this.results[3]
        // for(let i=0; i< this.results.length ;i++){
        //   if(i===2){
        //   }
        // }
        console.log(this.result3)
        console.log(this.results[3])
      }
    },
    mounted(){
      this.test();
    }
  }
</script>

<style lang="scss" scoped>

</style>
