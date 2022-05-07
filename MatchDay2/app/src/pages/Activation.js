import React, { Component } from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';

class Activation extends Component {
    constructor() {
        super();
        this.state = {
            isLoading: false,
            activationCode: null,
            message: null
        }
        this.getInputValue = this.getInputValue.bind(this);
        this.handleActivationCode = this.handleActivationCode.bind(this);
    }

    getInputValue(event) {
        // show the user input value to console
        const userValue = event.target.value;
        console.log(userValue);
        this.setState({activationCode: userValue});
    };

    handleActivationCode() {
        const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ activationCode: this.state.activationCode })
            };
            fetch('/user/activate', requestOptions)
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    this.setState({ message: data.message })
                    if (data.message === 'failed') {
                        console.log("no bueno");
                    }
                    if (data.message === 'activated') {
                        this.handleSuccess();
                    }
                });
    }

    handleSuccess() {
        window.location.href = '/';
    }

    handleLogout() {
        window.location.href = '/logout';
    }

    render() {
        // background-color: #343a40!important
        document.body.style = 'background-color: #343a40!important;';
        return (
        <>
            <header class="p-3 bg-dark text-white">
                <div class="container">
                    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

                        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                            <input type="password" class="form-control form-control-dark" placeholder="activation code..." aria-label="Activation code" onChange={this.getInputValue} />
                        </form>

                        <div class="text-end ml-5">
                            <button type="button" onClick={this.handleActivationCode} class="btn btn-warning mr-1">Activate account</button>
                            <button type="button" onClick={this.handleLogout} class="btn btn-outline-light">Logout</button>
                        </div>

                    </div>
                </div>
            </header>
            <div class="p-3 text-white">
                <h6><small>Enter the activation code provided to you by the administrator of the site</small></h6>
                <h6><small><i>Copyright (c) Adrianus, 2o22</i></small></h6>
            </div>
        </>
        )
    }
}

export default Activation;