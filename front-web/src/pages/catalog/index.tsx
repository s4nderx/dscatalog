import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';
import ProductCard from './components/ProductCard';
import './styles.scss';
import { http_client } from '../../core/utils/request';
const Catalog = () => {
    //qunado o componente iniciar, buscar a lista de produtos
    useEffect(() => {

        //limitacoes do fetch:
        // > muito verboso
        // > não tem suporte nativo para receber o progresso de upload de arquivos
        // > não tem suporte nativo para trabalhar query strings

        const params = {
            page: 0,
            linesPerPage: 12
        };
        http_client({ url: '/products', params }).then((response) =>
            console.log(response)
        );
    }, []);

    //quando a lisra de produtos estiver disponivel, popilar um estado no componente e listar os produtos dinamicamente

    return (
        <div className="catalog-container">
            <h1 className="catalog-title">Catálogo de produtos</h1>
            <div className="catalog-products">
                <Link to="/products/1">
                    <ProductCard />
                </Link>
                <Link to="/products/2">
                    <ProductCard />
                </Link>
                <Link to="/products/3">
                    <ProductCard />
                </Link>
                <Link to="/products/4">
                    <ProductCard />
                </Link>
                <Link to="/products/5">
                    <ProductCard />
                </Link>
                <Link to="/products/6">
                    <ProductCard />
                </Link>
                <Link to="/products/7">
                    <ProductCard />
                </Link>
                <Link to="/products/8">
                    <ProductCard />
                </Link>
                <Link to="/products/9">
                    <ProductCard />
                </Link>
                <Link to="/products/10">
                    <ProductCard />
                </Link>
            </div>
        </div>
    );
};

export default Catalog;
