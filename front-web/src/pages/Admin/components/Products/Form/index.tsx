import BaseForm from 'pages/Admin/components/BaseForm';
import { useState } from 'react';

type FormState = {
    name: string;
    price: string;
    category: string;
}

const Form = () => {

    const [formData, setFormData] = useState<FormState>({
        name: '',
        price: '',
        category: ''
    });

    const handleOnChange = (event: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        const name = event.target.name;
        const value = event.target.value;
        console.log({name, value});
        
        setFormData(data => ({ ...data, [name]: value}));
    };

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        console.log(formData);
        
    }

    return (
        <form onSubmit={handleSubmit}>
                <BaseForm title="CADASTRAR UM PRODUTO">
                    <div className="row">
                        <div className="col-6">
                            <input
                                value={formData.name}
                                name="name"
                                type="text"
                                className="form-control mb-5"
                                onChange={handleOnChange}
                                placeholder="Nome do Produto"
                            />

                            <select
                                value={formData.category}
                                className="form-control mb-5"
                                onChange={handleOnChange}
                                name="category"
                            >
                                <option value="livros">Livros</option>
                                <option value="computadores">Computadores</option>
                                <option value="eletronicos">Eletrônicos</option>
                            </select>

                            <input
                                value={formData.price}
                                name="price"
                                type="text"
                                className="form-control"
                                onChange={handleOnChange}
                            />
                        </div>
                    </div>
                </BaseForm>         
        </form>
    );
};

export default Form;
