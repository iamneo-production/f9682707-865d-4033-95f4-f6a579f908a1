import React, { useState } from "react";
import axios from "axios";
                                                                        //import statements
import "./AddProduct.css";
import Frame from "../../components/Frame/Frame";
import Topbox from "../../components/Navbar/Topbox";

const ProductTable = () => {
  const [loc, setloc] = useState([]);
  const [id, setid] = useState("");
  const [ids, setids] = useState("");                             //state variables
  const [bar, setbar] = useState("");
  const [quan, setquan] = useState("");
  const [ur, setur] = useState("");
  const [suppliers, setsuppliers] = useState("");
  const fetchData = () => {
    axios
      .get("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/product")
      .then((response) => {                                        //fecthing data from DB
        setProducts(response.data);
      })
      .catch((err) => console.log(err));
  };

  React.useEffect(() => {
    if (!localStorage.getItem("auth")) {
      window.location = "/login";                                             //login
    }
    fetchData();
    axios
      .get("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/locations")
      .then((response) => {
        setloc(response.data);
      })
      .catch((err) => {
        console.log(err);
      });
  });
  React.useEffect(() => {
    if (bar !== "")
      axios
        .get(`https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/pg?barcode=${bar}`)                   //barcode
        .then((res) => setids(res.data))
        .catch((err) => console.log(err));
  }, [bar]);

  React.useEffect(() => {
    if (ids === "") {
    } else {
      const date = new Date();
      const year = date.getFullYear();                                                           //current date
      const month = String(date.getMonth() + 1).padStart(2, "0");
      const day = String(date.getDate()).padStart(2, "0");

      const currentDate = `${year}-${month}-${day}`;
      const parsedInt = Number(ids);

      const j = {
        product: {
          id: parsedInt,
        },
        quantity: quan,
        location: ur,
        date: currentDate,
      };

      axios
        .post("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/inventory", j)
        .then((response2) => {
          console.log(response2);
        })
        .catch(function (error) {
          console.log(error);
        });
      const verdict = {
        productId: ids,
        quantity: quan,
        supplier: suppliers,
        timestamp: currentDate,
      };

      axios
        .post("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/purchase-orderss", verdict)
        .then((res) => console.log(res))
        .then((err) => console.log(err));

      setids("");
    }
  }, [ids]);

  const [products, setProducts] = useState([]);

  const ed = (i) => {
    setid(i.id);
  };
  const editProduct = () => {                                             //edit product
    let name = document.getElementById("nameed").value;
    let des = document.getElementById("Desed").value;
    let price = document.getElementById("pried").value;
    let quantity = document.getElementById("tityed").value;
    let location = document.getElementById("locaed").value;
    let barcode = document.getElementById("codeed").value;
    setbar(barcode);
    const jsosn = {
      id: id,
      name: name,
      price: price,
      quantity: quantity,
      location: location,
      barcode: barcode,
      description: des,
    };

    console.log(jsosn);
    axios
      .put("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/products", jsosn)
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  const deleteProduct = (id) => {                                                   //delete product
    console.log(id);
    axios
      .delete("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/products", { params: { id } })
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  const handleAddProduct = () => {
    let name = document.getElementById("name").value;                                     //add product
    let des = document.getElementById("Des").value;
    let price = document.getElementById("pri").value;
    let quantity = document.getElementById("tity").value;
    let location = document.getElementById("loca").value;
    let barcode = document.getElementById("code").value;
    let supplier = document.getElementById("supp").value;

    const json = {
      name: name,
      price: price,
      quantity: quantity,
      location: location,
      barcode: barcode,
      description: des,
    };

    axios
      .post("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/products", json)
      .then((res) => {
        setbar(barcode);
        setquan(quantity);
        setur(location);
        setsuppliers(supplier);
        console.log(res.data);
      })
      .catch((err) => console.log(err));

    const bars = {
      name: barcode,
      location: location,
    };

    axios
      .post("https://8080-addccdfdabcedefcacfefaabebceecbecadec.project.examly.io/barcode-scanners", bars)
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
  };

  return (
    <div>
      <Frame />
      <Topbox />
      <div>
        <div style={{ fontFamily: "Times New Roman" }}>
          <button
            id="add"
            className="btn btn"
            data-bs-toggle="modal"
            data-bs-target="#exampleModalpro"
            style={{
              float: "right",
              color: "black",
              backgroundColor: "lightblue",
            }}
          >
            ➕ Add Product                                                                      
          </button>
        </div>
        <div></div>
        <div className="table-container">
          <table class="table table-striped w-75" id="product-table">                       
            <thead>
              <tr>
                <th style={{ color: "Blue" }}>Product Name</th>
                <th style={{ color: "Blue" }}>Description</th>
                <th style={{ color: "Blue" }}>Price</th>
                <th style={{ color: "Blue" }}>Quantity</th>
                <th style={{ color: "Blue" }}>Location</th>
                <th style={{ color: "Blue" }}>Barcode</th>
              </tr>
            </thead>
            <tbody>
              {products.map((product, i) => (
                <tr key={product.id}>
                  <td>{product.name}</td>
                  <td>{product.description}</td>
                  <td>{product.price}</td>
                  <td>{product.quantity}</td>
                  <td>{product.location}</td>
                  <td>{product.barcode}</td>
                  <td>
                    <button
                      className="btn btny"
                      data-bs-toggle="modal"
                      data-bs-target="#exampleModaledit"
                      onClick={() => ed(product)}
                    >
                      ✏️
                    </button>
                    <button
                      className="btn btn"
                      onClick={() => deleteProduct(product.id)}
                    >
                      🗑️
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
      <div
        class="modal fade"
        id="exampleModalpro"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">                                                               
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">
                Add Product
              </h1>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div id="model" class="modal-body">
              <b>Name:</b>
              <input id="name"></input>
              <br></br>
              <br></br>
              <b>Description:</b>
              <input id="Des"></input>
              <br></br>
              <br></br>
              <b>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>{" "}
              <input id="pri"></input>
              <br></br>
              <br></br>
              <b>Quantity:</b>
              <input id="tity"></input>
              <br></br>
              <br></br>
              <b>Location:</b>
              <select id="loca">
                {loc.map((item, index) => (
                  <option>{item.name}</option>
                ))}
              </select>
              <br></br>
              <br></br>
              <b>Barcode:</b>
              <input id="code"></input>
              <br></br>
              <br></br>
              <b>Supplier:</b>
              <input id="supp"></input>
              <br></br>
              <br></br>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-danger"
                data-bs-dismiss="modal"
              >                                                                          
                Cancel
              </button>
              <button
                type="button"
                class="btn btn-primary"
                data-bs-dismiss="modal"
                onClick={handleAddProduct}
              >
                Submit                                                                     
              </button>
            </div>
          </div>
        </div>
      </div>
      <div
        class="modal fade"
        id="exampleModaledit"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">                                                        
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">
                Edit Product
              </h1>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div id="model" class="modal-body">
              <b>Id:</b>
              <input value={id} disabled="true"></input>
              <br></br>
              <br></br>
              <b>Name:</b>
              <input id="nameed"></input>
              <br></br>
              <br></br>
              <b>Description:</b>
              <input id="Desed"></input>
              <br></br>
              <br></br>
              <b>Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>{" "}
              <input id="pried"></input>
              <br></br>
              <br></br>
              <b>Quantity:</b>
              <input id="tityed"></input>
              <br></br>
              <br></br>
              <b>Location:</b>
              <select id="locaed">
                {loc.map((item, index) => (
                  <option>{item.name}</option>
                ))}
              </select>
              <br></br>
              <br></br>
              <b>Barcode:</b>
              <input id="codeed"></input>
              <br></br>
              <br></br>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-danger"
                data-bs-dismiss="modal"
              >
                Cancel
              </button>
              <button
                type="button"
                class="btn btn-primary"                                                 
                data-bs-dismiss="modal"
                onClick={editProduct}
              >
                Submit
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProductTable;
