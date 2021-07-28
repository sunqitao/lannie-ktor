package cn.hiio.ktor.test.service

import cn.hiio.ktor.configs.getCollection
import cn.hiio.ktor.configs.save
import cn.hiio.ktor.test.vo.TestTempVo

class TestService {
    companion object{
        fun saveTempUser(name:String,age:Int){
            val testTempVO = TestTempVo()
            testTempVO.name =name
            testTempVO.age = age
            testTempVO.save()
        }
    }
}