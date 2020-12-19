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
                <Redirect from="/admin" to="/admin/products" exact></Redirect>
            <Route path="/admin">
                <Admin></Admin>
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;
