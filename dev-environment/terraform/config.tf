resource "vault_generic_secret" "consumerloan" {
  path = "secret/consumerloan/dev"

  data_json = jsonencode(
    {
      "database"   = {
        "host"     = "172.17.8.220",
        "username" = "microservicio",
        "password" = "secr3t!"
      }
    }
  )
}