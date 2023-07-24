import Topbox from '../../components/Navbar/Topbox';
import Frame from '../../components/Frame/Frame';
import "./Report.css"
import { utils, writeFile } from "xlsx"
import Button from 'react-bootstrap/Button';
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Report() {
const [pros,setpros]=useState([]);
const [sell,setsell]=useState([]);
const [inv,setinv]=useState([]);

  React.useEffect(() => {
    if(!localStorage.getItem("auth")){
      window.location="/login"
    }
    axios.get("https://8080-cdcaeebeddfbdcceabcedefcacfefaabeaeaadbdbabf.project.examly.io/product").then((response) => {
        setpros(response.data)}).catch(err=>console.log(err));

        axios.get("https://8080-cdcaeebeddfbdcceabcedefcacfefaabeaeaadbdbabf.project.examly.io/sales").then((response) => {
        setsell(response.data)}).catch(err=>console.log(err));

        
        axios.get("https://8080-cdcaeebeddfbdcceabcedefcacfefaabeaeaadbdbabf.project.examly.io/inventory").then((response) => {
          setinv(response.data)}).catch(err=>console.log(err));
      
      
      
    },[pros,sell,inv] );

  

  const convertTableToXLSX = () => {

    const workbook = utils.book_new();
    const worksheet = utils.table_to_sheet(document.querySelector('.table'));
    utils.book_append_sheet(workbook, worksheet, 'Sheet1');
    writeFile(workbook, `Report_Data (${new Date().toLocaleDateString()}).xlsx`);
  };

  return (
    <div>
      <Frame />
      <Topbox />
      <div className='pt-5 d-flex justify-content-end pe-5' id='down'><Button className='' onClick={convertTableToXLSX}>Download Statement</Button></div>
      <div className='pt-5'>
        <table className="table" class="table table-striped w-75">
          <thead>
            <tr>   
              <th style={{ color: "Blue" }} scope="col">Id</th>
              <th style={{ color: "Blue" }} scope="col">Name</th>
              
              <th style={{ color: "Blue" }}  scope="col">Quantity</th>
              <th style={{ color: "Blue" }} scope="col">cost price</th>
              <th style={{ color: "Blue" }} scope='col'>sell price</th>
              <th style={{ color: "Blue" }} scope="col">Profit</th>
            </tr>
          </thead>
          <tbody>
            {pros.map((item, index) => {
              const val=sell.find((sp)=>sp.productId===item.id)  
              const inventory=inv.find((sps)=>sps.product && sps.product.id===item.id)
              // const pro=val?val.price-item.price:0;   
              const qson=inventory?inventory.quantity:0;
              const cost=qson*item.price;
              const sellprice=val?val.price:0;
              const pro=val?sellprice-cost:0;
              function vas(){
                console.log(inventory);
              }
              return(<tr key={index}>
                
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.quantity}</td>
                <td>{cost}</td>
                <td>{sellprice}</td>
                <td onClick={vas}>{pro}</td>
                
              </tr>);
              
              })}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default Report;