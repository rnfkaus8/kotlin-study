module.exports = {
  parser: '@typescript-eslint/parser',
  plugins: ['prettier', '@typescript-eslint', 'sonarjs', 'react', 'react-hooks', 'jsx-a11y', 'import'],
  settings: {
    'import/resolver': {
      typescript: {},
      'babel-module': {},
      node: {
        extensions: ['.js', '.jsx', '.ts', '.tsx'],
      },
    },
    'import/parsers': {
      '@typescript-eslint/parser': ['.ts', '.tsx'],
    },
  },
  extends: [
    'eslint:recommended',
    'airbnb',
    'airbnb/hooks',
    'prettier',
    'plugin:@typescript-eslint/recommended',
    'plugin:sonarjs/recommended',
    'plugin:react/recommended',
    'plugin:react-hooks/recommended',
    'plugin:jsx-a11y/recommended',
    'plugin:import/recommended',
  ],
  rules: {
    'prettier/prettier': [
      'error',
      {
        singleQuote: true, // 작은 따옴표 사용
        trailingComma: 'all', // 여러 줄을 사용할 때 후행 콤마 사용 방식
        semi: true, // 세미콜론 사용
        printWidth: 120, // 개행이 일어나는 한 행의 최대 너비
        arrowParens: 'always', // 화살표 함수 괄호 사용
      },
    ],
    // eslint:recommended
    'no-param-reassign': ['error', { props: true, ignorePropertyModificationsFor: ['state'] }],
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

    // react-hooks
    'react-hooks/exhaustive-deps': 'error',

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
};
