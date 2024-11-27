const mongoose = require('mongoose')
//Connection our Mongodb
mongoose.connect("mongodb://localhost:27017/Users").then(()=>{
    console.log("Database Connected")
}).catch(err => console.log(err))


//Here we create a Schema
const UserSchema = mongoose.Schema({
    firstName :{
        type:String,
        required : true,
    },
    lastName:{
        type : String
    },
    email:{
        type:String,
        required : true,
        unique:true,
    },
   jobTitle:{
    type:String
   },
   gender:{
    type:String
   }

},
{timestamps : true}
)

const User = mongoose.model('user',UserSchema)

module.exports = User