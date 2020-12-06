import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import NavBar from './core/components/NavBar';
import Admin from './pages/Admin';
import Catalog from './pages/catalog';
import ProductDetails from './pages/catalog/components/ProductDetails';
import Home from './pages/home';


const Routes = () => (
    <BrowserRouter>
    <NavBar></NavBar>
        <Switch>
            <Route path="/" exact>
                <Home></Home>
            </Route>
            <Route path="/products" exact>
                <Catalog></Catalog>
            </Route>
            <Route path="/products/:productId">
                <ProductDetails></ProductDetails>
            </Route>
            <Route path="/admin">
                <Admin></Admin>
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;