import React from 'react';
import { SubmitHandler, useForm } from 'react-hook-form';
import { Simulate } from 'react-dom/test-utils';
import error = Simulate.error;

type FormData = {
  name: string;
  city: string;
  street: string;
  zipcode: string;
};
const MemberCreateForm = () => {
  const { handleSubmit, register } = useForm<FormData>();

  const onSubmit: SubmitHandler<FormData> = (data) => {
    console.log(JSON.stringify(data));
    fetch('/api/members/new', {
      method: 'POST',
      headers: {
        'content-type': 'application/json;charset=UTF-8',
      },
      body: JSON.stringify(data),
    })
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        console.log(data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <label htmlFor="name">
        이름
        <input
          placeholder="이름을 입력하세요"
          {...register('name', { required: true })}
        />
      </label>
      <label htmlFor="city">
        도시
        <input
          {...register('city', { required: true })}
          placeholder="도시를 입력하세요"
        />
      </label>
      <label htmlFor="street">
        거리
        <input
          {...register('street', { required: true })}
          placeholder="거리를 입력하세요"
        />
      </label>
      <label htmlFor="zipcode">
        우편번호
        <input
          {...register('zipcode', { required: true })}
          placeholder="우편번호를 입력하세요"
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
};

export default MemberCreateForm;
