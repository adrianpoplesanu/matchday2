import { Outlet, Link } from "react-router-dom";
import '../App.css';
import './Layout.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function doLogout() {
    window.location.href = "logout";
}

const Profile = () => {
  return (
    <>
      <div>
      <h1>Profile page</h1>
      </div>

      <Outlet />
    </>
  )
};

export default Profile;