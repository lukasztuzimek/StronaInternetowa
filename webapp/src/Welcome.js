import React, {Component, useState} from 'react';
import {Button} from "react-bootstrap";
import Default from "./Default";
import Rent from "./Rent";
import Employee from "./Employee";

export default function Welcome() {
    let [component, setComponent] = useState("default");

    let rent = () => {
        setComponent("rent")
    }

    let employee = () => {
        setComponent("employee")
    }

    let currentComponent = <Default/>

    if(component === "default") currentComponent = <Default/>
    if(component === "rent") currentComponent = <Rent/>
    if(component === "employee") currentComponent = <Employee/>

    return (
        <div>
            <div className="customerdetails">
                <Button onClick={rent}>Info</Button>
                <Button onClick={employee}>Rezerwacje</Button>
            </div>
            {currentComponent}
        </div>
    );
}