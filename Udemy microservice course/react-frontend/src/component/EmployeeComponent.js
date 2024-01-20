import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeeComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            employee: {},
            department: {}
        }
    }
    
    componentDidMount(){
        EmployeeService.getEmployee().then((response) => {
            this.setState({employee : response.data.employeeDto})
            this.setState({department : response.data.departmentDto})

            console.log(this.state.employee)
            console.log(this.state.department)
            console.log(response)
        })
    }

    render() {
        return (
            <div><br /><br />
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'> View Employee Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Employee First Name : </strong> {this.state.employee.firstName}</p>
                            <p><strong>Employee Last Name : </strong> {this.state.employee.lastName}</p>
                            <p><strong>Employee Email : </strong> {this.state.employee.email}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'> View Department Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Depertment Name : </strong> {this.state.department.departmentName}</p>
                            <p><strong>Depertment Descriptions : </strong> {this.state.department.departmentDescription}</p>
                            <p><strong>Depertment code : </strong> {this.state.department.departmentCode}</p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default EmployeeComponent;