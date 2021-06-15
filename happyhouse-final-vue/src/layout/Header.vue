<template>
  <div class="header container">
    <SubMenu />
    <Logo />
    <Menu />
  </div>
</template>

<script>
import Logo from '@/components/header/Logo.vue';
import Menu from '@/components/header/Menu.vue';
import SubMenu from '@/components/header/SubMenu.vue';

export default {
  name: 'Header',
  components: {
    Logo,
    Menu,
    SubMenu,
  },
};
</script>

<style>
.header {
  height: 100%;
  width: 100%;
}
</style>
