import { useEffect, useState } from "react";
import Frame from "../../components/Frame/Frame";
import Topbox from "../../components/Navbar/Topbox";
import './Home.css';
import axios from "axios";


const Home = () => {

  const [data, setData] = useState(null);
  const [raw,setraw]=useState([]);
  

  useEffect(() => {
    if(!localStorage.getItem("auth")){
      window.location="/login"
    }
    fetch('http://localhost:8080/api/locations')
      .then(res => res.json())
      .then(data => {
        setData(data);
      });

  }, )


  const handleEdit = (e) => {
    // Handle edit functionality here
    const json={
      "id":e.id,
      "name":e.name,
      "address":e.address,
      "contact":e.contact
    }
    setraw(json);
    

  };



  const handleDelete = (id) => {
    
    
   
    
    axios.delete('http://localhost:8080/api/locations',{params:{id}}).then(function(response){console.log(response)}).catch(function(error){console.log(error)});
  };
  const submit=()=>{
  let name=document.getElementById("loc").value;
  let address=document.getElementById("adds").value;
  let contact=document.getElementById("con").value;

  const json={
    "name":name,
      "address":address,
      "contact":contact
  }
  axios.post("http://localhost:8080/api/locations",json).then(function(response){console.log(response)}).catch(function(error){console.log(error)});
  }
  const store=()=>{
  let id=document.getElementById("one").value;
  let name=document.getElementById("two").value;
  let address=document.getElementById("three").value;
  let contact=document.getElementById("four").value;
  
   const json={
    "id":id,
      "name":name,
      "address":address,
      "contact":contact
   }
   axios.put("http://localhost:8080/api/locations",json).then(function(response){console.log(response)}).catch(function(error){console.log(error)});
  }
  return (

      <div>
      <Frame/>
      <Topbox/>
    <div className="home">

      <div className="header">
        <h1>Location</h1>
        <button to="/add" className="add-location" data-bs-toggle="modal" data-bs-target="#exampleModal">Add Location </button>
      </div>
      <div className="table-container">
      <table className="table" class="table table-striped w-75">
          <thead>
            <tr>
              <th style={{ color: "Blue" }}>S.No</th>
              <th style={{ color: "Blue" }}>Name</th>
              <th style={{ color: "Blue" }}>Contact</th>
              <th style={{ color: "Blue" }}>Address</th>
              
            
            </tr>
          </thead>
          <tbody>
            {data && (data.map((row, index) => (
              <tr key={row.id}>
                <td>{row.id}</td>
                <td>{row.name}</td>
                <td>{row.contact}</td>
                <td>{row.address}</td>
                <td>
                  <button  className="btn btny"
                      data-toggle="modal" data-bs-toggle="modal" data-bs-target="#exampleModal1"  onClick={() => handleEdit(row)}>✏️</button>
                  <button className="btn btn" onClick={() => handleDelete(row.id)}>🗑️</button>
                  </td>
                  
              </tr>
            )))}
          </tbody>
        </table>
      </div>
    </div>
    <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Edit Location</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div id="model" class="modal-body">
       <b>id:</b> <input id="one" value={raw.id} disabled="true"></input><br></br><br></br>
       <b>Location:</b><input id="two"  ></input><br></br><br></br>
       <b>Address:</b> <input id="three"  ></input><br></br><br></br>
       <b>Contact:</b> <input id="four"  ></input>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-bs-dismiss="modal" onClick={store}>Save changes</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Add Location</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div id="model" class="modal-body">
       
       <b>Location:</b><input id="loc"  ></input><br></br><br></br>
       <b>Address:</b> <input id="adds"  ></input><br></br><br></br>
       <b>Contact:</b> <input id="con"  ></input>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onClick={submit}>Submit</button>
      </div>
    </div>
  </div>
</div>

    </div>

  );
}

export default Home;