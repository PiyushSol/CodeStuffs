const express = require('express')
const router = express.Router()


router.get('/',(req,res)=>{
 res.end("Blog home page")
})

router.get('/about',(req,res)=>{
    res.end("About blog homepage")
})



module.exports = router