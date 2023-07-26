import React, { useEffect, useState } from 'react';
import ReactDOM from 'react-dom';
import './App.css';
import logo from './images/img.jpeg';
import axios from 'axios';
function LoginPage() {
  
  const [rest,setrest]=useState("");


  React.useEffect(() => {
    if(rest==="Success"){
      window.location="/dashboard"
      localStorage.setItem("auth",true);
    } 
    
  }, );


   const  handleLogin=()=>{
    let user=document.getElementById("user").value;
    let pass=document.getElementById("pass").value;
    
    
   const credentails= {
      "username": user,
      "password": pass
   }

   axios.post("https://8080-edeaacdeebabcedefcacfefaabebceecbecadec.project.examly.io/login",credentails).then(res=>{setrest(res.data)
  
  }).catch(err=>console.log(err)); 

  

  
  

   
  };

  return (
    <div className="container">
      <img style = {{width:"10%",height:"20%"}} src= {logo} alt="IM_icon"></img>      
      <h1> Inventory Management System</h1>
      <h2>Login Page</h2>
      

      <div className="error">{rest}</div>
        <input className='in' id="user"
          type="text"
          placeholder="Username" />
        <input className='in' id='pass'
          type="password"
          placeholder="Password"  />
        <button className='but' onClick={handleLogin}>Login</button>
      
    </div>
  );
}

ReactDOM.render(<LoginPage />, document.getElementById('root'));

export default LoginPage

//login