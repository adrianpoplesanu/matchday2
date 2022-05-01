import React, { Component } from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';

class Activation extends Component {
    state = {
        isLoading: false,
        activationCode: null
    }

    getInputValue(event) {
        // show the user input value to console
        const userValue = event.target.value;

        console.log(userValue);
    };

    handleActivationCode() {
        const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ activationCode: 'aici pune codul de activare' })
            };
            fetch('/user/activate', requestOptions)
                .then(response => response.json())
                .then(data => this.setState({ postId: data.id }));
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
                            <button type="button" onClick={this.handleActivationCode} class="btn btn-warning">Activate account</button>
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