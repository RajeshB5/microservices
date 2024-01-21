import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';

export default function Home() {

    const [users, setUsers] = useState([])
    useEffect(()=>{
        loadUsers();
    }, []);

    const loadUsers=async ()=>{
        const result = await axios.get("http://localhost:8080/users");
        setUsers(result.data);
    };

  return (
    <div className='container'>
        <div className='py-4'>
        <table className="table border shadow">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">User Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">User ID</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    users.map((user,index)=>(
                        <tr>
                            <th scope="row" key={index}>{index+1}</th>
                            <td>{user.name}</td>
                            <td>{user.username}</td>
                            <td>{user.email}</td>
                            <td>{user.id}</td>
                            <td>
                                <Link className='btn btn-primary mx-2'>View</Link>
                                <Link className='btn btn-outline-primary mx-2'>Edit</Link>
                                <Link className='btn btn-danger mx-2'>Update</Link>
                            </td>
                        </tr>

                    ))
                }
                
            </tbody>
            </table>
        </div>
    </div>
  )
}
