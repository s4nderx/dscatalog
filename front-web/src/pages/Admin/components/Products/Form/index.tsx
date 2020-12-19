import BaseForm from 'pages/Admin/components/BaseForm';
import { useState } from 'react';

const Form = () => {

    const [name, setName] = useState('');
    const [price, setPrice] = useState('');
    const [category, setCategory] = useState('');

    const handleOnChangeName = (event: React.ChangeEvent<HTMLInputElement>) => {
        setName(event.target.value);
    };

    const handleOnChangePrice = (
        event: React.ChangeEvent<HTMLInputElement>
    ) => {
        setPrice(event.target.value);
    };

    const handleOnChangeCategory = (
        event: React.ChangeEvent<HTMLSelectElement>
    ) => {
        setCategory(event.target.value);
    };

    return (
        <BaseForm title="CADASTRAR UM PRODUTO">
            <div className="row">
                <div className="col-6">
                    <input
                        value={name}
                        type="text"
                        className="form-control mb-5"
                        onChange={handleOnChangeName}
                    />

                    <select
                        className="form-control mb-5"
                        onChange={handleOnChangeCategory}
                    >
                        <option value="livros">Livros</option>
                        <option value="computadores">Computadores</option>
                        <option value="eletronicos">Eletrônicos</option>
                    </select>

                    <input
                        value={price}
                        type="text"
                        className="form-control"
                        onChange={handleOnChangePrice}
                    />
                </div>
            </div>
        </BaseForm>
    );
};

export default Form;
