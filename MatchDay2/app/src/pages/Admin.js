import React, { Component } from 'react';
import $ from 'jquery';

class Admin extends Component {
    state = {
        isLoading: true,
        message: {}
    };

    sendData() {
        $.ajax({
          url: '/admin/competition/',
          type: 'PUT',
          data: {},
          success: function(data) {
            alert('Load was performed.');
          }
        });
    }

    handleChange(event) {
        //this.setState({value: event.target.value});
        //console.log(event.target.value);
        //this.state.value = event.target.value;
    }

    render() {
        return (
            <>
                <div>admin page here</div>
                <div>poor man postman</div>
                <div><b>PUT /admin/competition</b>
                    <form>
                        <textarea onChange={this.handleChange} />
                        <button type="button" onClick={this.sendData}>Send</button>
                    </form>
                </div>
            </>
        )
    }
}

export default Admin;