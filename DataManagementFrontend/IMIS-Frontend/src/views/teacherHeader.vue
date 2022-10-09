<template>
    <div>
        <div class="bgpicture"></div>
        <div class="teacher">
        <div class="teacher-pic"></div>
            <div class= "teacher-info">
                <div class="teacher-name">{{name}}</div>
                <div class="teacher-title">教师职称：{{title}}</div>
                <div class="tel-number">电话：{{telNumber}}</div>
                <div class="total-file">{{total}}</div>
            </div> 
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                name:"aaa",
                title:"aaa",
                telNumber:"1111111",
                total:"5"
            }
        },
        methods: {
            name() {
                
            }
        },
    }
</script>

<style lang="scss" scoped>

    .bgpicture {
        background-color:gainsboro;
        width:1200px;
        height:153px;
    }

    .teacher-pic {
        position: absolute;
        left:123px;
        top:185.5px;
        border-radius: 100%;
        background-image: 

    }

</style>