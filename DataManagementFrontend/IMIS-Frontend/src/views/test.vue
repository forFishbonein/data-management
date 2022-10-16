<template>
  <div>
    <button @click="test">点我</button>
  </div>
</template>

<script>
  import {test} from '@/api'
  export default {
    data() {
      return {
      }
    },
    methods: {
      test() {
        test().then(
          response =>{
            console.log(response.data.data)
          }
        )
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>
