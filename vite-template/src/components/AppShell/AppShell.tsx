import { AppShell, Burger, Group, Skeleton } from '@mantine/core';
import { useDisclosure } from '@mantine/hooks';
import { NavbarMinimalColored } from '../Navbar/NavbarMinimalColored';
import { ColorSchemeToggle } from '../ColorSchemeToggle/ColorSchemeToggle';
import { createBrowserRouter, Outlet, RouterProvider } from 'react-router-dom';
import FormProduto from '../Form/FormProduto';

export function BasicAppShell() {
  const [opened, { toggle }] = useDisclosure();

  return (
    <AppShell
      header={{ height: 60 }}
      navbar={{ width: 80, breakpoint: 'sm', collapsed: { mobile: !opened } }}
      padding="md"
    >
      <AppShell.Header>
        <Group h="100%" px="md">
          <Burger opened={opened} onClick={toggle} hiddenFrom="sm" size="sm" />
        </Group>
      </AppShell.Header>
      <AppShell.Navbar>
        <NavbarMinimalColored />
      </AppShell.Navbar>
      <AppShell.Main>
        <Outlet/>
      </AppShell.Main>
    </AppShell>
  );
}