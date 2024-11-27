const express = require('express')
const app = express()
const urlRoute = require("./routes/url")
const PORT =3000;
const URL = require("./models/url")
const { connection } = require("./connection")

connection("mongodb://localhost:27017/short-url").then(()=>console.log("Connected to Database"))

app.use(express.json())

app.use("/url",urlRoute);

app.get("/:shortId", async(req,res)=>{
const shortId = req.params.shortId;
const entry = await URL.findOneAndUpdate({
    shortId
}, { $push : {
    visitHistory :{timestamp : Date.now()},
}});

res.redirect(entry.redirectURL);
})
app.listen(PORT, ()=> console.log("Server is Connected"))