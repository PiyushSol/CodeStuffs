const express = require('express')
const cors = require('cors')
const bodyparser = require('body-parser')

const app = express();
const PORT = 5000;
app.use(cors())
app.use(bodyparser.json())

const users = [
  { email: 'test@example.com', password: 'Password@123' },
  { email: 'user@domain.com', password: 'User@456' },
];

app.post("/login",(req,res)=>{
    const {email,password} = req.body;
    
  const user = users.find((u) => u.email === email && u.password === password);

  if (user) {
    return res.status(200).json({ message: 'Login successful' });
  } else {
    return res.status(401).json({ message: 'Invalid credentials' });
  }
});

app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});