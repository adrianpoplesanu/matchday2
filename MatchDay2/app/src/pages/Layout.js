import { Outlet, Link } from "react-router-dom";
import React, { Component } from 'react';
import '../App.css';
import './Layout.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Layout extends Component {

    state = {
        isLoading: true,
        message: {}
    };

    handleLogout() {
        window.location.href = '/logout';
    }

    async componentDidMount() {
        const response = await fetch('/user/info');
        const body = await response.json();

        this.setState({ message: body, isLoading: false });
    }

    render() {
        const {message, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        console.log(message);

        return (
            <>
            <nav>
                <header class="p-3 bg-dark text-white">
                    <div class="container">
                        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

                            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <li>
                                <Link class="nav-link px-2 text-secondary" to="/">Matches</Link>
                            </li>
                            <li>
                                <Link class="nav-link px-2 text-secondary" to="/predictions">Predictions</Link>
                            </li>
                            <li>
                                <Link class="nav-link px-2 text-secondary" to="/profile">Profile</Link>
                            </li>
                            </ul>

                            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                                <input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search"></input>
                            </form>

                            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                                <img class="poza"
                                src="https://lh3.googleusercontent.com/a/AATXAJwuVkP5WxwquKLL9FSJ59AhMpG9QwYNGZx2Ob-J=s96-c"
                                />
                            </a>

                            <div class="text-end">
                                <span class="name">{message.name}</span>
                                <button type="button" onClick={this.handleLogout} class="btn btn-warning">Logout</button>
                            </div>

                        </div>
                    </div>
                </header>
            </nav>
            <Outlet />
            </>
        )
    }
};

export default Layout;