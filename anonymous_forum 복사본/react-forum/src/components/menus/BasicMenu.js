import { Link } from 'react-router-dom';
import './BasicMenu.css';
const BasicMenu = () => {
  return (
    <nav className="navbar">
      <div className="logoWapr">
        <div className="logo ">Rlog</div>
      </div>
      <div className="menuWarp">
        <ul className="menu">
          <li className="menuContent ">
            <Link to={'/'}>Home</Link>
          </li>
          <li className="menuContent">
            <Link to={'/api/register'}>ADD</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default BasicMenu;
