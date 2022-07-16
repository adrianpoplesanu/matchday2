import React from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ReactDOM from 'react-dom/client';
import './index.css';

import Layout from './pages/Layout';
import Home from './pages/Home';
// import Activation from './pages/Activation';
import Predictions from './pages/Predictions';
import Profile from './pages/Profile';
import Admin from './pages/Admin';
import Logout from './pages/Logout';
import NoPage from './pages/NoPage';


export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="predictions" element={<Predictions />} />
          <Route path="profile" element={<Profile />} />
          <Route path="admin" element={<Admin />} />
          <Route path="logout" element={<Logout />} />
          <Route path="*" element={<NoPage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);