import React from 'react';
import { Link, Route, Switch } from 'react-router-dom';

const Products = () => {
    return (
        <div>
            <Link className="mr-5" to="/admin/products">Listar produtos</Link>
            <Link className="mr-5" to="/admin/products/create">Criar produto</Link>
            <Link className="mr-5" to="/admin/products/10">Editar produto</Link>
            <Switch>
                <Route path="/admin/products" exact>
                    <h1>Exibir a listagem de produtos</h1>
                </Route>
                <Route path="/admin/products/create">
                    <h1>Criar um produto</h1>
                </Route>
                <Route path="/admin/products/:productId">
                    <h1>editar um produto</h1>
                </Route>
            </Switch>
        </div>
    );
};

export default Products;
