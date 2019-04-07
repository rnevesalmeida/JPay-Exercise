new Vue({
  el: '#app',
  data: {
    columns: ['Index', 'Scope', 'Name', 'Type', 'Value'],
    configurations: [{"scope":"2","name":"config name 2","type":"TYPE3","value":2},{"scope":"1","name":"config name 1","type":"TYPE2","value":1}]
  },
  methods: {
    //function to add data to table
    add: function() {
      this.configurations.push({
        scope: this.input.scope,
        name: this.input.name,
        type: this.input.type,
        value: this.input.value
      });

      for (var key in this.input) {
        this.input[key] = '';
      }
      this.persons.sort(alphabetically);
      this.$refs.name.focus();
    },
    //function to handle data edition
    edit: function(index) {
      this.editInput = this.configurations[index];
      console.log(this.editInput);
      this.configurations.splice(index, 1);
    },
    //function to send data to bin
    archive: function(index) {
      this.bin.push(this.configurations[index]);
      this.configurations.splice(index, 1);
      this.bin.sort(alphabetically);
    },
    //function to restore data
    restore: function(index) {
      this.persons.push(this.bin[index]);
      this.bin.splice(index, 1);
      this.bin.sort(alphabetically);
    },
    //function to update data
    update: function(){
      // this.persons.push(this.editInput);
       this.configurations.push({
        scope: this.editInput.scope,
        name: this.editInput.name,
        type: this.editInput.type,
        value: this.editInput.value
      });
       for (var key in this.editInput) {
        this.editInput[key] = '';
      }
      this.configurations.sort(alphabetically);
    },
    //function to definitely delete data
    deplete: function(index) {
      // console.log(this.bin[index]);
      this.bin.splice(index, 1);
    }
  }
});

//function to sort table data alphabetically
var alphabetically = function(a, b) {
  return (a.name > b.name);
};

$(function() {
  //initialize modal box with jquery
  $('.modal').modal();
});