import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import "./Topbox.css";

function Topbox() {


  const finish=()=>{
   localStorage.clear();
   window.location="/"
  }
  return (
    <div className='top'>
          
      <button onClick={finish} id="button" className='rounded' >Logout</button>
    </div>
  );
}
export default Topbox;