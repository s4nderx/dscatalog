import ProductDetails from 'pages/Catalog/components/ProductDetails';
import React from 'react';
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import NavBar from './core/components/NavBar';
import Admin from './pages/Admin';
import Catalog from './pages/Catalog';

import Home from './pages/Home';

const Routes = () => (
    <BrowserRouter>
        <NavBar />
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
                <Redirect to="/admin/products"></Redirect>
                <Admin></Admin>
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;
