import { useEffect } from 'react';

import Frame from '../../components/Frame/Frame';
import './Shipments.css';
import Topbox from '../../components/Navbar/Topbox';
import axios from 'axios';
import { useState } from 'react';
function Shipments() {
  const [datas, setdatas] = useState([]);
  useEffect(() => {
    if(!localStorage.getItem("auth")){
      window.location="/login"
    }

    axios.get('https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/shipment') // Replace with your backend endpoint
      .then(response => {
        setdatas(response.data);
        console.log(datas);
      })
      .catch(error => {
        console.error(error);
      });
  },);
  return (
    <div>
      <Frame />
      <Topbox />


      <span className='display-5 '>Shipments</span>
      <table class="table table-striped  w-75">

        <thead>
          <tr>
            <th style={{ color: "Blue" }} scope="col">id</th>
            <th style={{ color: "Blue" }} scope="col">ProductId</th>
            <th style={{ color: "Blue" }} scope="col">quantity</th>
            <th style={{ color: "Blue" }} scope="col">location</th>
            <th style={{ color: "Blue" }} scope="col">Date</th>
           
          </tr>
        </thead>
        <tbody>

          {
            datas.map((element, key) => {
              return (<tr>
                <td>{element.id}</td>
                <td>{element.productId}</td>
                <td>{element.quantity}</td>
                <td>{element.location}</td>
                <td>{element.timestamp}</td>
                
              </tr>
              );
            })
          }


        </tbody>
      </table>


    </div>
  );
}

export default Shipments;