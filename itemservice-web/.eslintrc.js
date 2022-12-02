module.exports = {
  extends: [
    'prettier',
    'airbnb',
    'eslint:recommended',
    'plugin:@typescript-eslint/recommended',
  ],
  rules: {
    'react/prefer-stateless-function': 0,
    'react/jsx-filename-extension': 0,
    'react/jsx-one-expression-per-line': 0,
    'react/function-component-definition': [
      2,
      {
        namedComponents: 'arrow-function',
        unnamedComponents: 'arrow-function',
      },
    ],
    'arrow-body-style': 0,
    'react/button-has-type': 'off',
    // eslint:recommended
    'no-param-reassign': [
      'error',
      { props: true, ignorePropertyModificationsFor: ['state'] },
    ],
    camelcase: 'off',
    'no-use-before-define': 'off',
    'no-shadow': 'off',
    'global-require': 'off',
    'no-await-in-loop': 'off',
    'class-methods-use-this': 'off',

    // eslint-plugin-import
    'import/named': 'off',
    'import/no-cycle': 'off', // THIS IS EXPENSIVE COMPUTATION
    'import/prefer-default-export': 'off',
    'import/extensions': 'off',
    'import/export': 'off',
    'import/no-unresolved': 'off',
    'import/no-extraneous-dependencies': 'off',
    'import/namespace': 'off',

    // eslint-plugin-react
    'react/jsx-filename-extension': ['warn', { extensions: ['.ts', '.tsx'] }],
    'react/prop-types': 'off',
    'react/jsx-wrap-multilines': 'off',
    'react/jsx-props-no-spreading': 'off',
    'react/display-name': 'off',
    'react/require-default-props': 'off',
    'react/no-unused-prop-types': 'warn',
    'react/no-array-index-key': 'warn',
    'react/jsx-no-literals': ['warn', { ignoreProps: true }],

    // @typescript-eslint/eslint-plugin
    '@typescript-eslint/no-non-null-assertion': 'off',
    '@typescript-eslint/explicit-module-boundary-types': 'off',
    '@typescript-eslint/no-unused-vars': 'warn',

    // eslint-plugin-sonarjs
    'sonarjs/prefer-immediate-return': 'off',
    'sonarjs/no-identical-functions': 'off',
    'sonarjs/no-duplicate-string': 'off',
    'sonarjs/cognitive-complexity': 'off', // DEFAULT: ERROR

    // eslint-plugin-jsx-a11y
    'jsx-a11y/accessible-emoji': 'off',
  },
  env: {
    browser: true,
  },
  parser: '@typescript-eslint/parser',
  plugins: ['@typescript-eslint'],
  root: true,
};
