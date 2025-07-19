import { useState } from "react";

const Login = ()=>{
  const [email , setEmail]=useState('');
  const [pass, setPass]=useState('');
  const [errors, setErrors]= useState({email:'',password:''});

 const checkEmail = (email) => {
  const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return re.test(email);
};

const checkPass = (pass) => {
  const re = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&#^])[A-Za-z\d@$!%*?&#^]{8,}$/;
  return re.test(pass);
};

  const handleSubmit =async (e)=>{
      e.preventDefault();
      const isValidEmail = checkEmail(email);
      const isValidPass = checkPass(pass);

      if(!isValidEmail ||!isValidPass){
        setErrors(
            {
                email:isValidEmail?'':"Invalid email format",
                password:isValidPass?"":"Password must be at least 8 characters long and include uppercase, lowercase, number, and special character."
            }
        );
        return;
      }
      setErrors({email:'',password:''});

      //calling backend to check the details
      const result = await fetch("http://localhost:5000/login",{
        method:'POST',
        headers:{
          'Content-Type':'application/json',
        },
        body:JSON.stringify({email,password:pass})
      });

      const data = await result.json();
      console.log(data);
  }


   return(
    <>
       <div className="mt-20 mx-auto w-1/2 h-3/4 flex items-center justify-center bg-sky-100 rounded-3xl">
  <form
    onSubmit={handleSubmit}
    className="flex flex-col space-y-5 p-8  w-full max-w-md"
  >
    <div>
      <label htmlFor="username" className="block text-lg font-medium mb-1">
        Email
      </label>
      <input
        type="text"
        placeholder="Enter email..."
        required
        className="p-3 w-full border border-gray-400 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      {errors.email && (
        <p className="text-red-600 text-sm mt-1">{errors.email}</p>
      )}
    </div>

    <div>
      <label htmlFor="password" className="block text-lg font-medium mb-1">
        Password
      </label>
      <input
        type="password"
        required
        className="p-3 w-full border border-gray-400 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
        placeholder="Enter password"
        value={pass}
        onChange={(e) => setPass(e.target.value)}
      />
      {errors.password && (
        <p className="text-red-600 text-sm mt-1">{errors.password}</p>
      )}
    </div>

    <button
      type="submit"
      className="bg-blue-600 text-white text-lg py-3 rounded-lg hover:bg-blue-700 transition"
    >
      Login
    </button>
  </form>
</div>
    </>
   )
}

export default Login;