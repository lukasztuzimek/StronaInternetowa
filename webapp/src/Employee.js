import React, {Component, useEffect, useState} from 'react';
import {Button} from "react-bootstrap";
import FormGroup from "react-bootstrap/lib/FormGroup";
import ControlLabel from "react-bootstrap/lib/ControlLabel";
import FormControl from "react-bootstrap/lib/FormControl";
import Table from "react-bootstrap/lib/Table";
import Rent from "./Rent";

export default function Employee() {
    let [name, setName] = useState("")
    let [login, setLogin] = useState("")
    let [singleData, setSingleData] = useState([])


    let handleSubmit = () => {
        console.log("localhost:8080/rent/getinfo/" + name.replace(/ /g, ''))
        fetch('http://localhost:8080/rent/getinfo/' + name.replace(/ /g, ''))
            .then(response => response.json())
            .then(data => {
                console.log("data")
                console.log(data)
                setSingleData(data)
            })
            .catch((err) => {
                console.error(this.props.url, err.toString())
            })
    }

    let handleLogin = () => {
        fetch('http://localhost:8080/rent/login/' + login)
            .then(response => response.json());
    }

    let reserve = () => {
        console.log('reserve')
        fetch('http://localhost:8080/rent/reserve/' + name.replace(/ /g, ''))
            .then(response => response.json())
            .then(data => {
                console.log("data")
                console.log(data)
                setSingleData(data)
            })
            .catch((err) => {
                console.error(this.props.url, err.toString())
            })

        handleSubmit()
    }

    let returnMovie = () => {
        fetch('http://localhost:8080/rent/return/' + name.replace(/ /g, ''))
            .then(response => response.json())
            .then(data => {
                console.log("data")
                console.log(data)
                setSingleData(data)
            })
            .catch((err) => {
                console.error(this.props.url, err.toString())
            })
        handleSubmit()
    }

    return (
        <div className="Login">
            <div>
                <form onSubmit={handleSubmit}>
                    <FormGroup controlId="email" bsSize="large">
                        <ControlLabel>Wyszukaj po nazwie ksiazki</ControlLabel>
                        <FormControl
                            autoFocus
                            type="text"
                            onChange={e => {
                                setName(e.target.value);
                            }}/>
                    </FormGroup>
                </form>
                <button type="submit" onClick={handleSubmit}>
                    Sprawdz Dostepnosc
                </button>
                <form onSubmit={handleLogin}>
                    <FormGroup controlId="email" bsSize="large">
                        <ControlLabel>Podaj nazwe uzytkownika</ControlLabel>
                        <FormControl
                            autoFocus
                            type="text"
                            onChange={e => {
                                setLogin(e.target.value);
                                console.log("e. " + e.target.value)
                                console.log("s. " + login)

                            }}/>
                    </FormGroup>
                </form>
                <button type="submit" onClick={handleLogin}>
                    Zaloguj
                </button>
                <Table>
                    <tr>
                        <th>Nazwa</th>
                        <th>Dostepnych</th>
                        <th>Rezerwuj</th>
                        <th>Oddaj</th>
                    </tr>
                    <tr>
                        <td>{singleData.title}</td>
                        <td>{singleData.available}</td>
                        <td><Button onClick={() => reserve()}>Rezerwuj</Button></td>
                        <td><Button onClick={returnMovie}>Oddaj</Button></td>
                    </tr>
                </Table>
            </div>
            <Rent id="2"/>
        </div>
    );

}