import { useState } from 'react';
import { TextInput } from '@mantine/core';
import classes from './FloatingLabelInout.module.css'

interface FloatingLabelInputProps {
  label: string;
  placeholder: string;
  required?: boolean;
}

export function FloatingLabelInput({label , placeholder, required = false }:FloatingLabelInputProps) {
  const [focused, setFocused] = useState(false);
  const [value, setValue] = useState('');
  const floating = value.trim().length !== 0 || focused || undefined;

  return (
    <TextInput
      label={label}
      placeholder={placeholder}
      required={required}
      classNames={classes}
      value={value}
      onChange={(event) => setValue(event.currentTarget.value)}
      onFocus={() => setFocused(true)}
      onBlur={() => setFocused(false)}
      mt="xl"
      autoComplete="nope"
      data-floating={floating}
      labelProps={{ 'data-floating': floating }}
    />
  );
}