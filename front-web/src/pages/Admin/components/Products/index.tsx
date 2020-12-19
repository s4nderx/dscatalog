import React from 'react';
import { Link, Route, Switch } from 'react-router-dom';
import List from './List';
import Form from './Form';
const Products = () => {
    return (
        <div>
            <Link className="mr-5" to="/admin/products">
                
                Listar produtos
            
            </Link>
            <Link className="mr-5" to="/admin/products/create">
                
                Criar produto
            
            </Link>
            <Link className="mr-5" to="/admin/products/10">
                
                Editar produto
            
            </Link>
            <Switch>
                <Route path="/admin/products" exact>
                    <List />
                </Route>
                <Route path="/admin/products/create">
                    <Form  />
                </Route>
                <Route path="/admin/products/:productId">
                    <h1>editar um produto</h1>
                </Route>
            </Switch>
        </div>
    );
};

export default Products;
