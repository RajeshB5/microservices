import axios from 'axios'


const EMPLOYEE_SERVICE_BASE_URL ="http://localhost:8081/api/employees/1"

class EmployeeService {
    getEmployee(){
        return axios.get(EMPLOYEE_SERVICE_BASE_URL);
    }
}

export default new EmployeeService()
