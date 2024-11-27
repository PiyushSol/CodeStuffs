const express = require('express')
const router = express.Router()

router.get('/',(req,res)=>{
    res.send("<h2>This is another Homepage </h2>")
})

router.get('/contact',(req,res)=>{
    res.send("<h3>This is contact page of homepage</h3>")
})


module.exports = router;