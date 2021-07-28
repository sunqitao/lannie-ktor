package cn.hiio.ktor.configs

import cn.hiio.ktor.common.vo.BaseModel
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.litote.kmongo.save
import org.litote.kmongo.updateOneById
import java.util.*

object MongoConfig

private fun getDatabase(databaseName:String): MongoDatabase {
    return KMongo.createClient("mongodb://saasmalluser:s12@fitment.db.com:27017/saasmall").getDatabase(databaseName)
}
fun <T:BaseModel> getCollection(t:T): MongoCollection<T> {
    val tempClass = t.javaClass
   return getDatabase("saasmall").getCollection(tempClass.simpleName,tempClass)
}


fun <T:BaseModel> T.save(){
    this.created = Date()
    this.updated = Date()
    this.deleted = false
    getCollection(this).save(this)
}
fun <T:BaseModel> T.update(){
    this.updated = Date()
    getCollection(this).updateOneById(this.id!!,this)
}