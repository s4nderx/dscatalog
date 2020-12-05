import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import NavBar from './core/components/NavBar';
import Admin from './pages/Admin';
import Catalog from './pages/Catalog';
import Home from './pages/Home';


const Routes = () => (
    <BrowserRouter>
    <NavBar></NavBar>
        <Switch>
            <Route path="/" exact>
                <Home></Home>
            </Route>
            <Route path="/catalog">
                <Catalog></Catalog>
            </Route>
            <Route path="/admin">
                <Admin></Admin>
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;