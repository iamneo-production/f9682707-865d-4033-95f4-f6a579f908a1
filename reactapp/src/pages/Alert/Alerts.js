import { useLocation, useParams } from 'react-router-dom';
import Card from 'react-bootstrap/Card';

import Topbox from '../../components/Navbar/Topbox';
import Frame from '../../components/Frame/Frame';
import { Container } from 'react-bootstrap';
import '../Alert/Alerts.css';
import { useEffect, useState } from 'react';
import axios from 'axios';

function Alerts() {
  const [alert,setalert]=useState([]);
  const [val,setval]=useState("");
  const [tot,settot]=useState("");
  const[totalert,settotalert]=useState("");

  const set=(item)=>{
    setval(item.id);
  }
 
  useEffect(()=>{
    if(!localStorage.getItem("auth")){
      window.location="/"
    }
    axios.get("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/productsless").then(response=>setalert(response.data)).catch(err=>console.log(err));
    axios.get("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/total").then(response=>settot(response.data)).catch(err=>console.log(err));
    axios.get("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/totalert").then(response=>settotalert(response.data)).catch(err=>console.log(err));
},)

const submits=()=>{
  let name=document.getElementById("pid").value;
  let quantity=document.getElementById("pqua").value;
  let Supplier=document.getElementById("psup").value;
  const date = new Date();
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, '0'); 
  const day = String(date.getDate()).padStart(2, '0');
  
  const currentDate = `${year}-${month}-${day}`;
  const json={
    "productId":name,
      "quantity":quantity,
      "supplier":Supplier,
      "timestamp":currentDate
  }
  axios.post("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/purchase-order",json).then(function(response){console.log(response)}).catch(function(error){console.log(error)});
  }
  return (
    <div>

      <Frame />
      <Topbox />
      <div id='card' class="row row-cols-1 row-cols-md-2 g-4">

        <div class="card-body text-bg-dark rounded">
          <h3 id="tit" class="card-title">Inventory Level</h3>
          <hr></hr>
          <h5>Total number of products in inventory :{tot }</h5>
        </div>


        <div class="col">
          <div class="card h-100">

            <div class="card-body text-bg-dark  rounded">
              <h3 class="card-title">Insufficient products</h3>
              <hr></hr>
              <h5 class="card-text">Total number of products in alert stage:{totalert}</h5>
            </div>
          </div>
        </div>
      </div>

      <table className="table" class="table table-striped  w-75">
        <thead>
          <tr>
            <th style={{ color: "Blue" }} scope="col">Id</th>
            <th style={{ color: "Blue" }} scope="col">Name</th>
            <th style={{ color: "Blue" }} scope="col">Price</th>
            <th style={{ color: "Blue" }} scope="col">Quantity</th>
            <th style={{ color: "Blue" }} scope="col">Location</th>
            <th style={{ color: "Blue" }} scope="col">Barcode</th>
            <th style={{ color: "Blue" }} scope="col">Description</th>
            <th style={{ color: "Blue" }} scope='col'>Action</th>
          </tr>
        </thead>
        <tbody>
          {
             alert.map((item, index) => (
              <tr key={index}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.price}</td>
                <td>{item.quantity}</td>
                <td>{item.location}</td>
                <td>{item.barcode}</td>
                <td>{item.description}</td>
                <td><button onClick={()=>set(item)}  className="btn btn" data-bs-toggle="modal" data-bs-target="#exampleModal2" >📦</button></td>
                
                
              </tr>
            ))
          }
        </tbody>
      </table>
      <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Purchase-Order</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div id="model" class="modal-body">
       <b>ProductId:</b><input id='pid' value={val} disabled="true"  ></input><br></br><br></br>
       <b>Quantity:</b><input id="pqua"  ></input><br></br><br></br>
       <b>Supplier:</b> <input id="psup"  ></input><br></br><br></br>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary" data-bs-dismiss="modal" onClick={submits} >Proceed</button>
      </div>
    </div>
  </div>
</div>
    </div>


  );
}






export default Alerts;