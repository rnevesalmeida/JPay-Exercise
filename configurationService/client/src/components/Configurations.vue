<template>
  <div class="container-fluid mt-4">
    <h1 class="h1">Configurations Manager</h1>
    <b-alert :show="loading" variant="info">Loading...</b-alert>
    <b-row>
      <b-col>
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Scope</th>
              <th>Name</th>
              <th>Value</th>
              <th>Type</th>
              <th>&nbsp;</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="configuration in configurations" :key="configuration.id">
              <td>{{ configuration.scope }}</td>
              <td>{{ configuration.name }}</td>
              <td>{{ configuration.value }}</td>
              <td>{{ configuration.type }}</td>
              <td class="text-right">
                <a href="#" @click.prevent="populateConfigurationsToEdit(configuration)">Edit</a> -
                <a href="#" @click.prevent="deleteConfiguration(configuration.id)">Delete</a>
              </td>
            </tr>
          </tbody>
        </table>
      </b-col>
      <b-col lg="3">
        <b-card :title="(model.id ? 'Edit Configuration ID#' + model.id : 'New Configuration')">
          <form @submit.prevent="saveConfiguration">
            <b-form-group label="Scope">
              <b-form-input type="text" v-model="model.scope"></b-form-input>
            </b-form-group>
            <b-form-group label="Name">
              <b-form-input type="text" v-model="model.name"></b-form-input>
            </b-form-group>
            <b-form-group label="Value">
              <b-form-input type="number" v-model="model.value"></b-form-input>
            </b-form-group>
            <b-form-group label="Type">
              <b-form-input type="text" v-model="model.type"></b-form-input>
            </b-form-group>
            <div>
              <b-btn type="submit" variant="success">Save Configuration</b-btn>
            </div>
          </form>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import api from '@/api'
export default {
  data () {
    return {
      loading: false,
      configurations: [],
      model: {}
    }
  },
  async created () {
    this.refreshConfigurations()
  },
  methods: {
    async refreshConfigurations () {
      this.loading = true
      this.configurations = await api.getConfigurations()
      this.loading = false
    },
    async populateConfigurationsToEdit (configuration) {
      this.model = Object.assign({}, configuration)
    },
    async saveConfiguration () {
      if (this.model.id) {
        await api.updateConfiguration(this.model.id, this.model)
        this.$swal('Updated successfully!')
      } else {
        await api.createConfiguration(this.model)
        this.$swal('Created successfully!')
      }
      this.model = {}
      await this.refreshConfigurations()
    },
    async deleteConfiguration (id) {
      if (confirm('Are you sure you want to delete this configuration?')) {
        if (this.model.id === id) {
          this.model = {}
        }
        await api.deleteConfiguration(id)
        this.$swal('Deleted successfully!')
        await this.refreshConfigurations()
      }
    }
  }
}
</script>