import axios from 'axios'

const client = axios.create({
  baseURL: 'http://localhost:7778/',
  json: true
})

export default {
  async execute (method, resource, data) {
    return client({
      method,
      url: resource,
      data
    }).then(req => {
      return req.data
    })
  },
  getConfigurations () {
    return this.execute('get', '/configurations')
  },
  getConfigurationById (id) {
    return this.execute('get', `/configurations/${id}`)
  },
  createConfiguration (data) {
    return this.execute('post', '/configurations', data)
  },
  updateConfiguration (id, data) {
    return this.execute('put', `/configurations/${id}`, data)
  },
  deleteConfiguration (id) {
    return this.execute('delete', `/configurations/${id}`)
  }
}
