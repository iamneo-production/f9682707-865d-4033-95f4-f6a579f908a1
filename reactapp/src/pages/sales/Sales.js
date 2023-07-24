import React, { useEffect, useState } from 'react';
import Frame from '../../components/Frame/Frame';
import Topbox from '../../components/Navbar/Topbox';
import axios from 'axios';


function Sales() {

const [sal,setsal]=useState([]);

    useEffect(()=>{
      if(!localStorage.getItem("auth")){
        window.location="/login"
      }
        axios.get("http://localhost:8080/api/sales").then(response=>setsal(response.data)).catch(err=>console.log(err));
    },)
    return (
        <div>
            <Frame />
            <Topbox />

            <div className='pt-2'>
        <h1 id='h1'>Sales</h1>

        <table className="table" class="table table-striped w-75">
          <thead>
            <tr>
              <th style={{ color: "Blue" }} scope="col">Id</th>
              <th style={{ color: "Blue" }} scope="col">Product_id</th>
              <th style={{ color: "Blue" }} scope="col">Quantity</th>
              <th style={{ color: "Blue" }} scope="col">Price</th>
              <th style={{ color: "Blue" }} scope="col">Date</th>
              
              
            </tr>


          </thead>
          <tbody>
            {sal.map((item, index) => (
              <tr key={index}>
                <td>{item.id}</td>
                <td>{item.productId}</td>
                <td>{item.quantity}</td>
                <td>{item.price}</td>
                <td>{item.timestamp}</td>
                
                
              </tr>
            ))}
          </tbody>
        </table>
      </div>

        </div>
    );
}

export default Sales;