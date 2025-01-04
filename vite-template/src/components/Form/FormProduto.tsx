import React, { ChangeEvent, FormEvent, useState } from 'react';
import { FloatingLabelInput } from '../FloatingInput/FloatingLabelInput';
import { Button, TextInput } from '@mantine/core';
import { useForm } from '@mantine/form';
import axios from 'axios';

export default function FormProduto() {

  const form = useForm({
    mode: 'uncontrolled',
    initialValues: {
      id: '',
      nome: '',
      quantidade: '',
      preco: '',
    },

  });

  const handleSubmit = async (values: any) => {
    try {
      const response = await axios.post('http://localhost:8080/api/produtos', values);
      console.log('Produto cadastrado:', response.data);
      form.reset();
    } catch (error) {
      console.error('Erro ao cadastrar produto:', error);
    }
  };

  const handleCancel = () => {
    form.reset(); // Reseta os valores do formulário para os valores iniciais
  };

  return (
    <><h1>CADASTRE UM NOVO PRODUTO</h1>
      <form onSubmit={form.onSubmit((values) => console.log(values))}>
        <TextInput label='Nome' placeholder='Coloque o nome do produto' required key={form.key('nome')}
          {...form.getInputProps('nome')} />
        <TextInput label='Preço' placeholder='Digite o preço do produto' required key={form.key('preco')}
          {...form.getInputProps('preco')} />
        <TextInput label='Quantidade' placeholder='Coloque a quantidade de produto no estoque' key={form.key('quantidade')}
          {...form.getInputProps('quantidade')} />
        <TextInput label='ID' placeholder='Coloque o ID do produto' required key={form.key('id')}
          {...form.getInputProps('id')} />

        <Button type='button' onClick={handleCancel} variant="filled" color="red" size="lg" radius="md">Cancelar</Button>
        <Button type='submit' variant="filled" color="green" size="lg" radius="md">Concluir</Button>
      </form></>
  )
} 