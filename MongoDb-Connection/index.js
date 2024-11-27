const express = require('express')
const app = express()
const Users = require("./Users")

app.use(express.json())


app.get("/",async(req,res)=>{
    const users = await Users.find({})
    const html = `
    <ul>
    ${users.map((user)=>`<li>${user.firstName} - ${user.email} - ${user.jobTitle}</li>`).join("")
}</ul>
    `
    res.send(html)
})


app.post("/",async(req,res)=>{
  let data =req.body; 
  console.log(data);
  const result =  await Users.create({
    firstName : data.firstName,
    lastName : data.lastName,
    email : data.email,
    jobTitle: data.jobTitle,
    gender : data.gender,
  })

  return res.status(201).json({msg:"Success"})
})

app.listen(3000,()=>console.log("Server is Up"))